package com.team1.stelling.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Slf4j
public  class PageableDTO {
    /*
        model.addAttribute("keyword", keyword);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
    *
    * */
    private String keyword;
    private int categoryStatus; // 0 - 전체, 1 - 신착, 2 - 완결
    private int startPage;
    private int endPage;
    private int realEnd;
    private int pageNumber;
    private int next,previous;
    private boolean hasPrev, hasNext;
    private int amount;
    private int total;
    private int pageCount;
    private Pageable pageable;


    public PageableDTO(int total, Pageable pageable) {
        this( pageable,total, 10,10);
    }

    public PageableDTO(Pageable pageable,int total, int pageCount,int amount){

        //        int nowPage = searchList.getPageable().getPageNumber() + 1;
    /*        int startPage = Math.max(nowPage - 4, 1);
            int endPage = Math.min(nowPage + 5, searchList.getTotalPages());*/


        this.previous = pageable.previousOrFirst().getPageNumber();
        this.next  = pageable.next().getPageNumber();
        this.pageNumber = pageable.getPageNumber()+1;
        this.total = total;
        this.pageCount = pageCount;
        this.endPage =   (int)(Math.ceil(pageNumber / 10.0)) * pageCount;
        log.info("page-------------------------------");
        log.info("endPage"+endPage);
        this.startPage = endPage - pageCount + 1;
        log.info("startPage-------------------------------");
        log.info("startPage"+startPage);
        /* realEnd 구하기 */
        this.realEnd = (int)Math.ceil(total /(double) amount);
        log.info("realEnd-------------------------------");
        log.info("realEnd"+realEnd);
        /* endPage와 비교 */
        //        endPage = endPage > realEnd ? realEnd : endPage;

        if(this.endPage > realEnd){
            this.endPage = this.realEnd == 0 ? 1 :this.realEnd;
        }

        /* hasPrev, next 구하기 */

        this.hasPrev = this.startPage > 1 ;
        // 이전 버튼 생성 여부 = 시작 페이지 번호가 1과 같으면 false, 아니면 true
        this.hasNext = this.endPage < this.realEnd;
        // 다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 개수가 총 게시글의 수보다
        // 크거나 같으면 false, 아니면 true



    }
}