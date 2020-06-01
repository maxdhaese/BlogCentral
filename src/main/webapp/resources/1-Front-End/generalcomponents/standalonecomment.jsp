<div class="card">
  <li class="comment" style="padding-bottom: 15px; width: 100%;">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div style="border: 2px solid; padding: 0.35em 0.75em 0.625em">


      <c:if test="${Author != null}">
        <c:set var="s" value="${Author.username}" />
        <c:set var="b" value="${requestScope.comment.author.username}" />
        <c:if test="${s == b}">
          <form action="deletecomment" method="post">
            <input type="hidden" name="commentID" value="${requestScope.comment.id}" />
            <input type="submit" value="X" style="margin-right: 5%; margin-left: 95%;" />
          </form>
        </c:if>
      </c:if>
      <div class="avatar">
        <a href="#">
          <img src="https://www.phplivesupport.com/pics/icons/avatars/public/avatar_53.png" alt="Eva photo avatar"
            class="avatar__img">
        </a>
      </div>
      <div class="comment__content">
        <div>
          <a href="author?username=${requestScope.comment.author.username}">
            <span class="user__link">${requestScope.comment.author.username}</span>
          </a>
          <span class="comment__pub-date"> - posted 1 week ago</span>
          <a href="#" title="report abuse" class="comment__action">
            <i class="fa fa-exclamation-triangle comment__action--report-abuse" aria-hidden="true"></i>
          </a>
        </div>
        <p>${requestScope.comment.message}</p>
        <footer class="comment__action--footer">
          <a href="#" title="like" class="comment__action">like</a>
          <a href="#" title="reply" class="comment__action">reply</a>
        </footer>
      </div>
    </div>
  </li>
</div>