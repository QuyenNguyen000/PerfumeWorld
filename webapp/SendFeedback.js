/*
 	Feedback.html 
 */

function SendFeedback(){
  var subject = feedback.subject.value;
  var comment = feedback.comment.value;
  window.open('mailto:ntoquyen000@gmail.com?subject='+subject+'&body='+comment);
}