package drive;

import board.BoardDAO;
import board.BoardDTO;

public class Ex3 {
	
	public static void main(String[] ar) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getOne(8);
		System.out.println(dto);
	}
}
