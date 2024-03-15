package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.InputBeans;

/**
 * Servlet implementation class Input
 */
public class InputServlet extends HttpServlet {

	/**
	 * [GET]初期表示処理。
	 * 　　・入力画面を表示する。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		InputBeans inputBeans = new InputBeans();
		if (session != null) {
			inputBeans = (InputBeans) session.getAttribute("input");
			// セッションクリア。
			request.getSession().invalidate();
		}

		request.setAttribute("input", inputBeans);
		request.setAttribute("errors", new HashMap<>());

		String view = "/WEB-INF/views/input.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * [POST]「確認画面へ」ボタン押下時のリクエスト処理。
	 * 　　・入力内容にエラーがあった場合、入力画面を表示する。
	 * 　　・エラーが無かった場合、確認画面を表示する。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatcher = null;

		// リクエスト情報取得。
		InputBeans inputBeans = new InputBeans(request);

		// バリデーションチェック。
		Map<String, String> errors = inputBeans.validation();
		if (errors != null && errors.size() > 0) {
			request.setAttribute("input", inputBeans);
			request.setAttribute("errors", errors);

			// エラーがあった場合は、入力画面へ。
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/input.jsp");
			dispatcher.forward(request, response);
			return;
		}

		request.setAttribute("input", inputBeans);

		// セッションクリア。
		request.getSession().invalidate();

		// エラーが無かったので、確認画面へ。
		dispatcher = request.getRequestDispatcher("/WEB-INF/views/confirm.jsp");
		dispatcher.forward(request, response);
	}

}
