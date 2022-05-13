package com.team1.stelling.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name ="TBL_RECENTVIEW")
@SequenceGenerator(name ="RECENTVIEW_SEQ" , allocationSize = 1)
@Getter
@Setter
@ToString(of = {"recentViewNumber"})
@AllArgsConstructor
public class RecentViewVO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECENTVIEW_SEQ")
    @Column(name = "RECENTVIEW_NUMBER")
   private Long recentViewNumber;   /* 최근 본 작품 번호*/

    @ManyToOne
    @JoinColumn(name = "USER_NUMBER")
    private  UserVO userVO; // userNum FK

    @ManyToOne
    @JoinColumn(name = "NOVEL_NUMBER")
    private NovelVO novelVO;                //  Fk NOVEL_NUMBER NUMBER,

    public RecentViewVO() {;}

}
