/**
 * Created by dina on 27/09/2017.
 */
$(document).ready(function() {
    var href = window.document.URL;
    var del = href.split('?')[1];
    var navn = del.split('=')[1];
    var quizName = navn.split('&')[0];

    var teller = 1;
    $('#leggtil').click(function () {
        teller = teller + 1;
        $('#sprs').append(
            '<br><br><h6>Spørsmål nr. ' + teller + '</h6>' +
            '<label for="question">Spørsmål</label>' +
            '<input type="text" class="form-control" id="sprs' + teller + '" placeholder="Spørsmål">' +
            '<div class="form-group"> <label for="url'+teller+'">Bildeurl</label> <input type="text" class="form-control" id="url'+teller+'"></div>'+
            '<div class="form-group"> <label>Svar 1</label> <input type="text" class="form-control" id="q1' + teller + '">' +
            '</div> <div class="form-group">  <label>Svar 2</label>' +
            '<input type="text" class="form-control" id="q2' + teller + '">' +
            '</div> <div class="form-group"> <label>Svar 3</label> <input type="text" class="form-control" id="q3' + teller + '">' +
            '</div> <div class="form-group"> <label>Svar 4</label> <input type="text" class="form-control" id="q4' + teller + '">' +

            '</div> Riktig alternativ: <div class="form-check form-check-inline"> <label class="form-check-label">' +
            '<input class="form-check-input" type="radio" name="inlineRadioOptions'+teller+'" id="' + teller + '1" value="option1" checked> 1' +
            '</label> </div> <div class="form-check form-check-inline"> <label class="form-check-label"> <input class="form-check-input" type="radio" name="inlineRadioOptions'+teller+'" id="' + teller + '2" value="option2"> 2' +
            '</label> </div> <div class="form-check form-check-inline"> <label class="form-check-label"> <input class="form-check-input" type="radio" name="inlineRadioOptions'+teller+'" id="' + teller + '3" value="option3"> 3 </label>' +
            '</div> <div class="form-check form-check-inline"> <label class="form-check-label"> <input class="form-check-input" type="radio" name="inlineRadioOptions'+teller+'" id="' + teller + '4" value="option4"> 4' +
            '</label></div>');
    });

    function getQuestions() {
        var questions = [];
        for(var i=1; i<=teller; i++){
            var question = $("#sprs"+i).val();
            var url = $("#url"+i).val();

            var answers = [];
            var answer1 = $("#q"+1+i).val();
            if(answer1!="") answers.push(answer1);
            var answer2 = $("#q"+2+i).val();
            if(answer2!="") answers.push(answer2);
            var answer3 = $("#q"+3+i).val();
            if(answer3!="") answers.push(answer3);
            var answer4 = $("#q"+4+i).val();
            if(answer4!="") answers.push(answer4);
            var correct = 1;
            for(var j=1; j<=4; j++){
                var radio = $("#"+i+j).prop('checked');
                if(radio){
                    correct = j;
                }
            }
            questions.push({
                question: question,
                correctanswer: correct,
                answers: answers,
                url: url
            });
        }
        return questions;
    }

    $("#submit").click(function(){
        $.ajax({
            url: 'rest/quizzes/' + quizName,
            type: 'POST',
            data: JSON.stringify(getQuestions()),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json'
        });

        window.location.href="quizliste.html";
    });
});