package jp.co.rakus.stockmanagement.web;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * メンバー関連のリクエストパラメータが入るフォーム.
 * @author igamasayuki
 *
 */
public class MemberForm {
	/** 名前 */
	@NotBlank(message="名前を入力して下さい")
	private String name;
	/** メールアドレス */
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="メールアドレスを入力してください")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message="パスワードを入力してください")
	private String password;
	
	/**確認パスワード*/
	@NotBlank(message="パスワードを入力してください")
	private String password2;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
