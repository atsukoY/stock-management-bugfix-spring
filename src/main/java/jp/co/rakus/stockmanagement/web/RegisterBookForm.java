package jp.co.rakus.stockmanagement.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * 本のデータを格納するためのクラス.
 * 
 * @author atsuko.yoshino
 *
 */
public class RegisterBookForm {

	/** 本の名前 */
	private String name;
	/** 著者 */
	private String author;
	/** 出版社 */
	private String publisher;
	/** 価格 */
	private String price;
	/** IBNSコード */
	private String isbnCode;
	/** 発売日 */
	private String saleDate;
	/** 説明 */
	private String explanation;
	/** 画像 */
	private MultipartFile image;
	/** 在庫数 */
	private String stock;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getIntPrcice() {

		return Integer.parseInt(price);
	}

	
	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		System.out.println(saleDate);
		this.saleDate = saleDate;
	}

	public Date getDateSaleDate() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date formatDate = sdf.parse(this.saleDate);
		return formatDate;
		
	}
	
	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getIsbnCode() {
		return isbnCode;
	}
	
	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}
	

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public Integer getIntStock(){
		
		return Integer.parseInt(stock);
	}

}
