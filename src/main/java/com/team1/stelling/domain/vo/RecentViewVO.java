package com.team1.stelling.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name ="TBL_RECENTVIEW")
@SequenceGenerator(name ="RECENTVIEW_SEQ" , allocationSize = 1)
@Getter
@ToString(of = {"recentViewNumber"})
@NoArgsConstructor
public class RecentViewVO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECENTVIEW_SEQ")
    @Column(name = "RECENTVIEW_NUMBER")
    Long recentViewNumber;   /* 최근 본 작품 번호*/

    @ManyToOne
    @JoinColumn(name = "USER_NUMBER")
    UserVO userVO; // userNum FK

}
