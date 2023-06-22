package com.rualone.app.domain.member.application;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.rualone.app.domain.member.dao.MemberRepository;
import com.rualone.app.domain.member.dto.request.MemberModifyRequest;
import com.rualone.app.domain.member.entity.Member;
import com.rualone.app.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    @Value("${spring.cloud.gcp.storage.bucket}")
    private String bucketName;

    private final Storage storage;
    private final MemberRepository memberRepository;

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new NotFoundException(Member.class, id));
    }

    @Override
    public Member findByEmail(String email) {
        Member loginMember = memberRepository.findByEmail(email).get();
        return loginMember;
    }

    @Override
    public void modify(MemberModifyRequest memberModifyRequest) {
        Member findMember = findByEmail(memberModifyRequest.getEmail());
        findMember.modify(memberModifyRequest);
    }

    @Override
    public void updateProfileImg(MultipartFile profileImg, Long memberId) {
        Member findMember = findById(memberId);
        if (findMember.getProfileImg() != null) {
            removeImgFile(findMember.getProfileImg());
        }

        String imgName = updateImgFile(profileImg);
        findMember.modifyProfileImg(imgName);
    }

    private void removeImgFile(String prevImg) {
        Blob blob = storage.get(bucketName).get(prevImg);
        boolean deleted = blob.delete();

        if (deleted) {
            log.info("이미지 삭제 성공: {}", blob);
        } else {
            log.info("이미지 삭제 실패: {}", blob);
        }
    }

    public String updateImgFile(MultipartFile profileImg) {
        log.info("Service entered");
        String uuid = UUID.randomUUID().toString();
        String ext = profileImg.getContentType();

        try {
            storage.create(
                    BlobInfo.newBuilder(bucketName, uuid)
                            .setContentType(ext)
                            .build(),
                    profileImg.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("이미지 저장 성공: {}", uuid);

        return uuid;
    }

    @Override
    public void removeProfileImg(Long memberId) {
        Member findMember = findById(memberId);
        if (findMember.getProfileImg() != null) {
            removeImgFile(findMember.getProfileImg());
        }
        findMember.modifyProfileImg(null);
    }

    @Override
    public void delete(String loginId) {
        Member findMember = findByEmail(loginId);
        memberRepository.delete(findMember);
    }

}
