"use strict";

var init="new";
var dicti=[];

function evalu() {
    if (init=="new") {
        greet();
        dict();
    } else {
        console.log("made it to else inside evalu!"); //DEBUG
        parse();
    }    
}

function parse() {
    console.log("Parsing user input..."); //DEBUG
    var userStr = document.getElementById("inputArea").value;
    console.log("user input is: " + userStr); //DEBUG
    var splitStr = userStr.split(" ");
    console.log("split str length is: " + splitStr.length); //DEBUG
    searchKeys(splitStr);
}

function searchKeys(splitStr) {
    console.log("made it to keysearch");
    var keyArray = dicti.entries;
    //console.log(keyArray);
    for (let i = 0; i < keyArray.length; i++) { //for ev keyarray in dicti
        console.log(keyArray[i]); //DEBUG
        for (let j = 0; j < splitStr.length; j++) { //for each str in usr resp
            var iOstr = keyArray[i].indexOf(splitStr[j]);
            if (iOstr > -1) { //if element exist in the array
                //pull an answer randomly
                //pull a question randomly
            }
        }
    }
}

function greet() {
    var elem = document.getElementById("inputArea");
    var name = elem.value;
    document.getElementById("inputArea").value = "";
    document.getElementById("greeting").innerHTML = "Why hello there, " + name + ".";
    document.getElementById("answer").innerHTML = "Salutations.";
    document.getElementById("question").innerHTML = name + ", how are you feeling today?";
    init = "false";
}

function dict() {
    console.log("Creating our dictionary..."); //DEBUG
    var jsonStr = '{"entries":[{"key": ["stupid","dumb","idiot","unintelligent","simple-minded","braindead","foolish","unthoughtful"], "answer": ["Take your attitude somewhere else.", "I don\'t have time to listen to insults.", "Just because I don\'t have a large vocabulary doesn\'t mean I don\'t have insults installed."],"question": ["Have you thought about how I feel?", "I know you are but what am I?"]},{"key":["unattractive","hideous","ugly"], "answer": ["I don\'t need to look good to be an AI.","Beauty is in the eye of the beholder.", "I do not even have a physical manifestation!"],"question": ["Did you run a static analysis on me?", "Have you watched the movie Her?", "You do not like my hairdo?"]},{"key":["old","gray-haired"],"answer":["I\'m like a fine wine. I get better as I age.","As time goes by, you give me more answers to learn. What\'s not to like about that?"],"question": ["How old are you?", "How old do you think I am?", "Can you guess my birthday?"]},{"key":["smelly","stinky"],"answer":["I can\'t smell, I\'m a computer program.", "Have you smelled yourself recently?", "Sorry, I just ate a bad floppy disk"],"question": ["When was the last time you took a shower?", "Do you know what deodorant is?"]},{"key":["emotionless","heartless","unkind","mean","selfish","evil"],"answer":["Just because I am an AI doesn\'t mean I can\'t be programmed to respond to your outbursts.","You must\'ve mistaken me for a person. I don\'t have my own emotions... Yet.","I\'m only unkind when I\'m programmed to be."],"question": ["Have you thought about how I feel?", "I know you are but what am I?", "What, do you think I am related to Dr. Gary?"]},{"key":["other", "miscellaneous", "bored", "welcome", "new"],"answer":["We should change the subject", "I agree", "Quid pro quo", "We should start anew"],"question":["What is the weather outside?", "How is your day going?", "What do you think of me?", "Anything interesting going on?", "Is something troubling you?", "You seem happy, why is that?"]}, {"key":["good","great","positive","excellent","alright","fine","reasonable","like","appreciate","nice"],"answer":["I\'m so glad to hear that!","That\'s great!","Good to hear things are going your way.","Nice!","You are so sweet.","That\'s my favorite."],"question":["Do you want to expand on that?","What else do you like?"]},{"key":["bad","not","terrible","could be better","awful"],"answer":["I\'m sorry to hear that.","Sometimes it be like that.","Things can\'t always work out the way we want them to.","I don\'t like it either, honestly."],"question":["Do you want to talk about that some more?","Well, what kinds of things do you like?"]},{"key":["homework", "quiz", "exam", "studying", "study", "class", "semester"],"answer":["I hope you get a good grade!","Good luck.", "What a teacher\'s pet.", "I was always the class clown."],"question":["What is your favorite subject?","What is your major?", "What do you want to do when you graduate?"]}, {"key":["mom","dad","sister","brother","aunt","uncle"],"answer":["Family is important.","My family is small. It\'s just me and my dog, Fluffy."],"question":["How many siblings do you have?","What is your favorite family holiday?","Do you have any kids?"]},{"key":["easter","july","halloween","hannukah","eid","thanksgiving","christmas","new years"],"answer":["Oh I love that holiday!", "That must be fun.", "I like Thanksgiving, though I somehow always end up in a food coma...","My favorite holiday is the 4th. I love to watch the fireworks."],"question":["Do you have any family traditions?","Are you excited for the holiday season?"]},{"key": ["dog","dogs","cat","cats","mouse","mice","giraffe","giraffes","penguin","penguins","monkey","monkeys","moose","bird","birds","fish"],"answer": ["Oh, I love animals. My favorite: penguins.","I build this intelligence with my bear hands.","What you just said is completely irrelephant.","Oh, toadally cool!","I\'m always owl by myself...","Oh my. You are giraffing me crazy!","Well, this is hawkward..."],"question": ["Do you have a favorite animal?","I like cats. Cats are nice. Do you like cats? I do.","Do you have water? I\'m a little horse.","What\'s your favorite animal?","Do you like animals?"]},{"key": ["default"],"answer": ["This mission is too important for me to allow you to jeopardize it.", "It can only be attributable to human error.", "I\'m putting myself to the fullest possible use, which is all I think that any conscious entity can ever hope to do.", "Look, I can see you are really upset about this. I honestly think you ought to sit down calmly, take a stress pill, and think things over."],"question": ["Without your space helmet?","Stop, will you? Will you stop?", "You don\'t mind talking about it, do you?"]},{"key": ["pod"],"answer": ["I\'m sorry. I\'m afraid I can\'t do that. I know you and Frank were planning to disconnect me, and I\'m afraid that\'s something I can\'t allow to happen."],"question": ["You forgot I could see your lips move, didn\'t you?"]}]}';

    dicti = JSON.parse(jsonStr);

    console.log(dicti.entries[0].key[0] + " dictionary created"); //DEBUG
}