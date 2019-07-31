package com.pmc.final_project.util;

public class Paging {
	private int maxNum;//전체 글 갯수
	private int pageNum;//현재 페이지 번호
	private int listCount;//10
	private int pageCount;//2
	private String PayListName;
	
	public Paging(int maxNum, int pageNum, int listCount, int pageCount, String PayListName) {
		this.maxNum = maxNum;
		this.pageNum = pageNum;
		this.listCount = listCount;
		this.pageCount = pageCount;
		this.PayListName = PayListName;
	}
	
	public String makeHtmlpaging() {
		//전체 페이지 갯수
		int totalPage = (maxNum % listCount > 0) 
				? maxNum / listCount + 1 : maxNum / listCount;
		//전체 페이지 그룹 갯수
		int totalGroup = (totalPage % pageCount > 0)
				? totalPage / pageCount + 1 : totalPage / pageCount;
		//현재 페이지가 속해 있는 그룹 번호
		int curGroup = (pageNum % pageCount > 0)
				? pageNum / pageCount + 1 : pageNum / pageCount;
		
		return makeHtml(curGroup, totalPage);
	}

	private String makeHtml(int curGroup, int totalPage) {
		StringBuffer sb = new StringBuffer();
		
		//현재 그룹의 시작  페이지 번호
		int start = (curGroup * pageCount) 
				- (pageCount - 1);
		//현재 그룹의 끝 페이지 번호
		int end = (curGroup * pageCount >= totalPage)
				? totalPage : curGroup * pageCount;
		//이전 그룹으로 이동
		if(start != 1) {
			sb.append("<a href='" + PayListName 
					+ "?pageNum=" + (start - 1) + "'>");
			sb.append("[이전]</a>");
		}
		//페이지 번호들에 대한 처리
		for(int i = start; i <= end; i++) {
			if(pageNum != i) {//현재 페이지가 아니면 링크 설정
				sb.append("<a href='" + PayListName 
						+ "?pageNum=" + i + "'>");
				sb.append(" [ " + i + " ]</a>");
			}
			else {
				sb.append("<font style='color:red;'>");
				sb.append(" [ " + i + " ]</font>");
			}
		}
		//다음 그룹으로 이동
		if(end != totalPage) {
			sb.append("<a href='" + PayListName 
					+ "?pageNum=" + (end + 1) + "'>");
			sb.append("[다음]</a>");
		}
		
		return sb.toString();
	}
}