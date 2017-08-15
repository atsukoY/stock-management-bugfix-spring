package jp.co.rakus.stockmanagement.service;

import jp.co.rakus.stockmanagement.domain.Member;
import jp.co.rakus.stockmanagement.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * メンバー関連サービスクラス.
 * @author igamasayuki
 *
 */
@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	
//	public List<Member> findAll(){
//		return memberRepository.findAll();
//	}
//	
//	public Member findOne(Integer id) {
//		return memberRepository.findOne(id);
//	}
	
	public Member findOneByMailAddressAndPassword(String mailAddress, String password){
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		String encoderPass = encoder.encode(password);
		System.out.println(encoderPass);
		Member member = memberRepository.findByMailAddressAndPassword(mailAddress, encoderPass);
		
		return member;
	}
	
	public Member save(Member member){
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
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
