package com.team1.stelling.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

// 소설 찜한 테이블
@Component
@Entity
@Table(name ="TBL_MYPICK")
@SequenceGenerator(name ="MYPICK_SEQ" , allocationSize = 1)
@Getter
@Setter
@ToString(of = {"myPickNumber","myPickPick"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyPickVO {
    /* 시퀀스 -> MYPICK_SEQ */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MYPICK_SEQ")
    @Column(name = "MYPICK_NUMBER")
    private Long myPickNumber; // 번호
    @Column(name = "MYPICK_PICK")
    private int myPickPick; /*찜이면 1 아니면 0 ?*/
    @ManyToOne
    @JoinColumn(name = "USER_NUMBER")
    private UserVO userVO; /* 찜한 소설의 번호 FK  */
    @ManyToOne
    @JoinColumn(name = "NOVEL_NUMBER")
    private NovelVO novelVO; // 찜한 사용자  FK

    public void updateMyPickNumber(Long myPickNumber) {
        this.myPickNumber = myPickNumber;
    }

    public void updateMyPickPick(int myPickPick) {
        this.myPickPick = myPickPick;
    }

    public void updateUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public void updateNovelVO(NovelVO novelVO) {
        this.novelVO = novelVO;
    }


}
