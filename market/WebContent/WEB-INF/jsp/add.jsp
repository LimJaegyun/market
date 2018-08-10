<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>등록</title>
	
	<script type="text/javascript">
    attachFile = {
            idx:0,
            add:function(){ // 파일필드 추가
                var o = this;
                var idx = o.idx;
     
                var div = document.createElement('div');
                div.style.marginTop = '3px';
                div.id = 'file' + o.idx;
     
                var file = document.all ? document.createElement('<input name="files">') : document.createElement('input');
                file.type = 'file';
                file.name = 'files';
                file.size = '40';
                file.id = 'fileField' + o.idx;
     
                var btn = document.createElement('input');
                btn.type = 'button';
                btn.value = '삭제';
                btn.onclick = function(){o.del(idx)}
                btn.style.marginLeft = '5px';
     
                div.appendChild(file);
                div.appendChild(btn);
                document.getElementById('attachFileDiv').appendChild(div);
     
                o.idx++;
            },
            del:function(idx){ // 파일필드 삭제
                if(document.getElementById('fileField' + idx).value != '' && !confirm('삭제 하시겠습니까?')){
                    return;
                }
                document.getElementById('attachFileDiv').removeChild(document.getElementById('file' + idx));
            }
        }
</script>
</head>
	
<body>
	<form action="add" method="post" enctype="multipart/form-data">
		<div id="attachFileDiv">
			<input type="hidden" name="memberSeq" value="${sessionNo}">
			상품명 <input type="text" name="name" placeholder="상품명 등록"> <br>
			타이틀 <input type="text" name="title" placeholder="타이틀 등록"> <br>
			태그 <input type="text" name="tag" placeholder="#태그 등록(최대4개)"> <br>
			가격 <input type="text" name="price" placeholder="가격 등록"> <br>
			수량 <input type="text" name="count" placeholder="수량"> <br>
			상세설명 <br>
			<textarea rows="10" cols="30" name="detail" placeholder="제품 상세설명 등록"></textarea>
			<input type="file" name="files" value="" size="40"><br>
			<input type="button" value="추가" onclick="attachFile.add()" style="margin-left:5px"><br>
			<input type="submit" value="받아랏!!!">
			<a href="/main/view/${sessionNo}"><input type="button" value="취소"/></a>
		</div>
	</form>
</body>
</html>
