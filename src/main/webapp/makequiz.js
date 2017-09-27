/**
 * Created by dina on 27/09/2017.
 */
$(document).ready(function() {
    $("#submit").click(function () {
        $.ajax({
            url: 'rest/quizzes/',
            type: 'POST',
            data: JSON.stringify({
                quizName: $("#quizName").val(),
                time: $("#time").val(),
                tpq: $("#tpq").val()
            }),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function () {
                window.location.href = 'makeQuestions.html?qn='+$("#quizName").val();
            }
        });
    });
});