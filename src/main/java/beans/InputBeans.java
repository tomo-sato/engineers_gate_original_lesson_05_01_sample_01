package beans;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.StringUtil;


/**
 * Input Beans
 * 入力画面で入力された値を保持するクラス。
 *
 * @author tomo-sato
 */
public class InputBeans {

	/** 名前 */
	private String name = "";
	/** 問い合わせ内容 */
	private String body = "";

	/** エラーメッセージ */
	private Map<String, String> errors = new HashMap<String, String>();

	/**
	 * コンストラクタ
	 */
	public InputBeans() {
		super();
	}

	/**
	 * コンストラクタ
	 * リクエストパラメータをこのクラスのプロパティに展開し、インスタンスを生成する。
	 * @param request HttpServletRequest
	 */
	public InputBeans(HttpServletRequest request) {
		this.name = request.getParameter("name");
		this.body = request.getParameter("body");
	}

	/**
	 * バリデーション
	 * @return エラーメッセージを返す。
	 */
	public Map<String, String> validation() {

		if (StringUtil.isEmpty(this.name)) {
			this.errors.put("name", "氏名は必須項目となります。");
		}
		if (StringUtil.isEmpty(this.body)) {
			this.errors.put("body", "問い合わせ内容は必須項目となります。");
		}

		return this.errors;
	}

	/**
	 * keyを指定し、エラーメッセージを取得する。
	 * @param key キー
	 * @return エラーメッセージを返す。
	 */
	public String getError(String key) {
		return this.errors.get(key);
	}


	// -------------------------
	// getter/setter
	// -------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
}
