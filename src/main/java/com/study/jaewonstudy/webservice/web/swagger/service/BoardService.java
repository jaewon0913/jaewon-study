package com.study.jaewonstudy.webservice.web.swagger.service;

import java.util.List;

import com.study.jaewonstudy.webservice.web.swagger.model.Board;

public interface BoardService {
	List<Board> getAllBoards();
	Board getBoardByBoardNo(int boardNo);
	boolean insertBoard(Board board);
	boolean updateBoard(Board board);
	boolean deleteBoardByBoardNo(int boardNo);
}
