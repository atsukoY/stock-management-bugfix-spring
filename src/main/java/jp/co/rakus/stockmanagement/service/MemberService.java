package jp.co.rakus.stockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import jp.co.rakus.stockmanagement.domain.Member;
import jp.co.rakus.stockmanagement.repository.MemberRepository;

/**
 * メンバー関連サービスクラス.
 * @author igamasayuki
 *
 */
@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
//	public List<Member> findAll(){
//		return memberRepository.findAll();
//	}
//	
//	public Member findOne(Integer id) {
//		return memberRepository.findOne(id);
//	}
	
	public Member findOneByMailAddressAndPassword(String mailAddress, String password){
//		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		String encoderPass = encoder.encode(password);
		System.out.println(encoderPass);
		Member member = memberRepository.findByMail(mailAddress);
		if(new StandardPasswordEncoder().matches(password,member.getPassword())){
			
			return member;
		}else{
			
			return null;
		}
		
	}
	
	public Member save(Member member){
//		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		String encoderPass = encoder.encode(member.getPassword());
		member.setPassword(encoderPass);
		
		return memberRepository.save(member);
	}
	
	/**
	 * メールアドレスがあるかどうか検索します.
	 * @param mail メールアドレス
	 * @return　メンバー情報を返します
	 */
	public Member findByMail(String mail){
		
		return memberRepository.findByMail(mail);
	}
	
//	public Member update(Member member){
//		return memberRepository.save(member);
//	}
//	
//	public void delete(Integer id){
//		memberRepository.delete(id);
//	}
}
