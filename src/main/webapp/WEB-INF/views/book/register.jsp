<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"  %>
<body>
<div class="cotainer">
<h3>書籍登録フォーム</h3>
	<div class="span8">
		<div class="row">
			<c:out value="${member.name}"/>さん　こんにちは！<br>
	<a href="${pageContext.request.contextPath}/logout/sessionInvalidate">ログアウト</a>
			<table class="table table-striped">
			<form:form modelAttribute="registerBookForm" action="${pageContext.request.contextPath}/book/register" enctype="multipart/form-data">
			  <tr>
			    <th>
			      書籍名
			    </th>
			    <td>
			      <form:input path="name"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      著者
			    </th>
			    <td>
			      <form:input path="author"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      出版社
			    </th>
			    <td>
			      <form:input path="publisher"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      価格
			    </th>
			    <td>
			      <form:input path="price"/>円
			    </td>
			  </tr>
			  <tr>
			    <th>
			      ISBNコード
			    </th>
			    <td>
			      <form:input path="isbnCode"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      発売日
			    </th>
			    <td>
			      <form:input type="date" path="saleDate" value="yyyy-MM-dd"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      説明
			    </th>
			    <td>
			      <form:textarea path="explanation"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      画像
			    </th>
			    <td>
			      <input type="file" name="image" accept="image/*">
			    </td>
			  </tr>
			  <tr>
			    <th>
			      在庫数
			    </th>
			    <td>
					<form:input path="stock"/><br>
			    </td>
			  </tr>
			  <tr>
			  	<td>
			  	</td>
			  	<td>
			  		<input type="submit" value="登録"/>
			  	</td>
			  	</tr>
			  	</form:form>
 			</table>
 			<form action="${pageContext.request.contextPath}/book/list">
			  		<input type="submit" value="戻る">
			</form>
		</div>
	</div>
</div>
</body>