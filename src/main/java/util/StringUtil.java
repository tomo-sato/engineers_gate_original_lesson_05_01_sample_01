package util;

/**
 * 文字列操作に関する機能を提供します。
 *
 * @author tomo-sato
 */
public class StringUtil {

	/**
	 * 引数の値がemptyか否かをチェックする。
	 * @param str チェック対象の文字列。
	 * @return 判定結果。true.empty、false.emptyではない。
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 改行コードを<br />タグに変換した情報を返却する。
	 * @param s 入力文字列
	 * @return 変換後の文字列を返却します。
	 */
	public static String nl2br(String s) {
		return nl2br(s, true);
	}

	/**
	 * 改行コードを<br />、または、<br>タグに変換した情報を返却する。
	 * @param str 入力文字列
	 * @param isXhtml XHTML準拠の改行タグの使用する場合はtrueを指定します。
	 * @return 変換後の文字列を返却します。
	 */
	public static String nl2br(String str, boolean isXhtml) {
		if (str == null || "".equals(str)) {
			return "";
		}

		String tag = isXhtml ? "<br />" : "<br>";
		return str.replaceAll("\\r\\n|\\n\\r|\\n|\r", tag);
	}
}