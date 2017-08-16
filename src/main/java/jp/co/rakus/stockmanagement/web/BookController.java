package jp.co.rakus.stockmanagement.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.rakus.stockmanagement.domain.Book;
import jp.co.rakus.stockmanagement.service.BookService;

/**
 * 書籍関連処理を行うコントローラー.
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/book")
@Transactional
@WebServlet("/UploadServlet")
public class BookController {
	@Autowired
	private BookService bookService;
	/**
	 * フォームを初期化します.
	 * @return フォーム
	 */
	@ModelAttribute
	public BookForm setUpForm() {
		return new BookForm();
	}
	
	/**
	 * 登録用フォームを初期化します.
	 * @return 登録用フォーム
	 */
	@ModelAttribute
	public RegisterBookForm setUpRegisterForm(){
		
		return new RegisterBookForm();
	}
	
	/**
	 * 書籍リスト情報を取得し書籍リスト画面を表示します.
	 * @param model モデル
	 * @return 書籍リスト表示画面
	 */
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
		return "book/list";
	}
	
	/**
	 * 書籍詳細情報を取得し書籍詳細画面を表示します.
	 * @param id 書籍ID
	 * @param model　モデル
	 * @return　書籍詳細画面
	 */
	@RequestMapping(value = "show/{bookId}")
	public String show(@PathVariable("bookId") Integer id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "book/show";
	}
	
	/**
	 * 書籍更新を行います.
	 * @param form フォーム
	 * @param result リザルト情報
	 * @param model　モデル
	 * @return　書籍リスト画面
	 */
	@RequestMapping(value = "update")
	public String update(@Validated BookForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return show(form.getId(), model);
		}
		Book book = bookService.findOne(form.getId());
		book.setStock(form.getStock());
		bookService.update(book);
		return list(model);
	}
	
	/**
	 * 登録データ画面に移動します.
	 * @return 登録データ画面
	 */
	@RequestMapping("/registerInput")
	public String registerInput(){
		
		return "book/register";
	}
	
	/**
	 * 入力されたデータを登録します.
	 * @param form 入力したデータ
	 * @param model　モデルオブジェクト
	 * @return　リスト一覧にもどる
	 * @throws IOException ネット上のエラーを無視します
	 * @throws IllegalStateException　 不正の文を無視します
	 * @throws ParseException 構文解析のエラー
	 */
	@RequestMapping("/register")
	public String register(RegisterBookForm form, Model model) throws IllegalStateException, IOException, ParseException{
		
		Book book = new Book();
		book.setName(form.getName());
		book.setAuthor(form.getAuthor());
		book.setPublisher(form.getPublisher());
		book.setPrice(form.getIntPrcice());
		book.setIsbncode(form.getIsbnCode());
		book.setSaledate(form.getDateSaleDate());
		book.setExplanation(form.getExplanation());
		form.getImage().transferTo(new File("C:/env/workspace-web/stock-management-bugfix-spring/src/main/webapp/img/"+form.getImage().getOriginalFilename()));
		String imageName= form.getImage().getOriginalFilename();
		book.setImage(imageName);
		book.setStock(form.getIntStock());
		bookService.save(book);
		
		return list(model);
	}


}


