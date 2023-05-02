package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.constant.ApiPattern;
import com.example.demo.dto.request.board.PatchBoardDto;
import com.example.demo.dto.request.board.PostBoardDto;
import com.example.demo.dto.response.ResponseDto;
import com.example.demo.dto.response.board.DeleteBoardResponseDto;
import com.example.demo.dto.response.board.GetBoardResponseDto;
import com.example.demo.dto.response.board.GetListResponseDto;
import com.example.demo.dto.response.board.GetMyLikeListResponseDto;
import com.example.demo.dto.response.board.PostMyListResponseDto;
import com.example.demo.dto.response.board.GetSearchTagResponseDto;
import com.example.demo.dto.response.board.GetTop15SearchWordResponseDto;
import com.example.demo.dto.response.board.GetTop3ListResponseDto;
import com.example.demo.dto.response.board.PatchBoardResponseDto;
import com.example.demo.dto.response.board.PostBoardResponseDto;
import com.example.demo.service.BoardService;

@RestController
@RequestMapping(ApiPattern.BOARD)
public class BoardController {

    @Autowired
    private BoardService boardService;

    private final String POST_BOARD = "/post-board";

    private final String GET_LIST = "/list";
    private final String GET_MY_LIST ="/my-list";
    private final String GET_SEARCH_TAG = "/search-tag/{tag}";
    private final String GET_BOARD = "/{boardNumber}";
    private final String GET_TOP3_LIST = "/top3-list";
    private final String GET_TOP15_SEARCH_WORD = "/top15-search-word";
    
    private final String PATCH_BOARD = "";
    private final String POST_LIKE_LIST = "/like-list";

    private final String DELETE_BOARD = "/{boardNumber}";
    
    
    @PostMapping(POST_BOARD)
    public ResponseDto<PostBoardResponseDto> postBoard(@AuthenticationPrincipal String email, @RequestBody PostBoardDto requestBody) {
        ResponseDto<PostBoardResponseDto> response = boardService.postBoard(email, requestBody);
        return response;
    }

    @GetMapping(GET_LIST)
    public ResponseDto<List<GetListResponseDto>> getList() {
        ResponseDto<List<GetListResponseDto>> response = boardService.getList();
        return response;
    }

    @GetMapping(GET_MY_LIST)
    public ResponseDto<List<PostMyListResponseDto>> getMyList(
        @AuthenticationPrincipal String email
    ) {
        ResponseDto<List<PostMyListResponseDto>> response = boardService.getMyList(email);
        return response;
    }

    @PatchMapping(PATCH_BOARD)
    public ResponseDto<PatchBoardResponseDto> patchBoard(@AuthenticationPrincipal String email, @RequestBody PatchBoardDto requestBody) {
        ResponseDto<PatchBoardResponseDto> response = boardService.patchBoard(email, requestBody);
        return response;
    }
    
    @PostMapping(POST_LIKE_LIST)
    public ResponseDto<List<GetMyLikeListResponseDto>> myLikeList(@AuthenticationPrincipal String email) {
        ResponseDto<List<GetMyLikeListResponseDto>> response = boardService.myLikeList(email);
        return response;
    }
    
    @GetMapping(GET_SEARCH_TAG)
    public ResponseDto<List<GetSearchTagResponseDto>> searchTag(@PathVariable("tag")String tag) {
        ResponseDto<List<GetSearchTagResponseDto>> response = boardService.searchTag(tag);
        return response;
    }

    //특정게시물 가져오기
    @GetMapping(GET_BOARD)
    public ResponseDto<GetBoardResponseDto> getBoard(
        @PathVariable("boardNumber") int boardNumber
    ) {
        ResponseDto<GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    //인기검색어15개 리스트 가져오기
    @GetMapping(GET_TOP15_SEARCH_WORD)
    public ResponseDto<GetTop15SearchWordResponseDto> getTop15SearchWord() {
        ResponseDto<GetTop15SearchWordResponseDto> response = boardService.getTop15SearchWord();
        return response;
    }
    //좋아요 상위3개 리스트 가져오기
    @GetMapping(GET_TOP3_LIST)
    public ResponseDto<List<GetTop3ListResponseDto>> getTop3List() {
        ResponseDto<List<GetTop3ListResponseDto>> response = boardService.getTop3List();
        return response;
    }
    
    //게시물 삭제
    @DeleteMapping(DELETE_BOARD)
    public ResponseDto<DeleteBoardResponseDto> deleteBoard(
        @AuthenticationPrincipal String email,
        @PathVariable("boardNumber") int boardNumber
    ) {
        ResponseDto<DeleteBoardResponseDto> response = boardService.deleteBoard(email, boardNumber);
        return response;
    }
}
