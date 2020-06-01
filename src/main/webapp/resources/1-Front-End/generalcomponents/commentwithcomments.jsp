<li class="comment" style="padding-bottom: 15px">
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
        <a style="visibility: visible; margin: 0; padding: 0;" title="reply"
          class="comment__action collapsible">reply</a>

        <form style="display: none;" id="comment__form" action="sendcommentoncomment" method="post"
          class="comments__form_form" style="padding-top:15px">
          <textarea style="resize: vertical;" id="comment__textarea" placeholder="Join the discussion..." cols="49"
            rows="4" maxlength="250" name="usercomment">
          </textarea>
          <input type="hidden" name="id" value="${requestScope.comment.id}" />
          <input type="submit" value="reply" />
        </form>
      </footer>

    </div>
  </div>
  <ul class="comment__replies">

    <c:forEach items="${requestScope.comment.comments}" var="comment">
      <c:set var="comment" value="${comment}" scope="request" />
      <c:import url="../generalcomponents/commentwithcomments.jsp" />
    </c:forEach>
  </ul>
</li>