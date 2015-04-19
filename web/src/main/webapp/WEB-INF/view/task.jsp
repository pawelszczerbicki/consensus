<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<p>Name: ${task.name}</p>
<p>Cores: ${task.cores}</p>
<p>Progress: ${task.progress}</p>
<p>State: <c:if test="${task.finished == true}">Finished</c:if><c:if test="${task.finished == false}">In progress</c:if></p>
<p>File: <a href="<c:url value="${task.fileUrl}"/>">${task.fileName}</a></p>