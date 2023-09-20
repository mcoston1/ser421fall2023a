<script>
    export default {
        data() {
            return {
                currentplayer:1,
                player1score:0,
                player2score:0,
                player3score:0,
                currentcat:'',
                currentquest:'',
                cat1id:'',
                cat2id:'',
                cat3id:'',
                cat4id:'',
                category1:'',
                category2:'',
                category3:'',
                category4:''
            }
        },  
         methods: {
                category(number) {
                    //makes the fetch call with the url
                    const url = "https://opentdb.com/api_category.php";
                    fetch(url).then((resp) => resp.json()).then(function(data) {
                        let categories = data.trivia_categories;
                        console.log(categories); //DEBUG
                        let controlbool = true;
                        while (controlbool) { //ensure randomization is not pisspoor
                            var rando = Math.floor(Math.random()*(24)); //randomly choose one of the numbers.
                            switch(rando) {
                                case 4:
                                    console.log("Failed. Index: " + rando);
                                break;
                                case 12:
                                    console.log("Failed. Index: " + rando);
                                break;
                                case 18:
                                    console.log("Failed. Index: " + rando);
                                break;
                                case 21:
                                    console.log("Failed. Index: " + rando);
                                break;
                                case 23:
                                    console.log("Failed. Index: " + rando);
                                break;
                                default:
                                    console.log("Randomization turned out in your favor woooo!");
                                    console.log("Number is: " + rando);
                                    controlbool = false;
                            }
                        }
                        console.log(categories[rando].name);

                        switch (number) {
                            case 1:
                                document.getElementById("category1").innerHTML = categories[rando].name;
                                this.cat1id = categories[rando].id;
                                break;
                            case 2:
                                document.getElementById("category2").innerHTML = categories[rando].name;
                                this.cat2id = categories[rando].id;
                                break;
                            case 3:
                                document.getElementById("category3").innerHTML = categories[rando].name;
                                this.cat3id = categories[rando].id;
                                break;
                            case 4:
                                document.getElementById("category4").innerHTML = categories[rando].name;
                                this.cat4id = categories[rando].id;
                                break;
                        }

                        

                    }).catch (function(error) {
                        console.log(JSON.stringify(error));
                    });
                }, //end of category method

          //then access the guts of said json object to display the category
          //also set the global cat id to use for later

          //add in error handling for cat repeats & the few gary mentioned !have necesasry qs

          
          requestTriviaQuestion(categoryID, difficulty) {
            //api call 
            const apiUrl = "https://opentdb.com/api.php?amount=1&category=" + categoryID;
            const diff = "&difficulty=" + difficulty;
            const type= "&type=boolean";
          }
        }
    }
</script>
{{category()}}
<template>
    <div id="gameboard">
        <span class="playerscores">
            <div id="player1score">Player 1: {{player1score}}</div> 
            <div id="player2score">Player 2: {{player2score}}</div> 
            <div id="player3score">Player 3: {{player3score}}</div>
        </span>
        <table id="board">   
            <caption style="color:black; font-weight: bold;"> Jeopardy!</caption>     
            <tr class="boardrow">
                <th id="category1">{{category(1)}}</th>
                <th id="category2">{{category(2)}}</th>
                <th id="category3">{{category(3)}}</th>
                <th id="category4">{{category(4)}}</th>
            </tr>
            <tr>
                <td>$100</td>
                <td>$100</td>
                <td>$100</td>
                <td>$100</td>
            </tr>
            <tr>
                <td>$200</td>
                <td>$200</td>
                <td>$200</td>
                <td>$200</td>
            </tr>
            <tr>
                <td>$300</td>
                <td>$300</td>
                <td>$300</td>
                <td>$300</td>
            </tr>
            <tr>
                <td>$400</td>
                <td>$400</td>
                <td>$400</td>
                <td>$400</td>
            </tr>
            <tr>
                <td>$500</td>
                <td>$500</td>
                <td>$500</td>
                <td>$500</td>
            </tr>
        </table> 
        <h4>Category: {{currentcat}}</h4>
        <h4>Value: {{currentquest}}</h4>
        <h4>Question: </h4> <br/>
        <div><button>True</button> <button>False</button></div>
    </div>
</template>

<style>
table, td {
  border: 2px solid black;
  border-collapse: collapse;
  padding: 15px;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  font-size:x-large;
  background-color: blue;
  color:yellow;  
}

th {
  border: 2px solid black;
  border-collapse: collapse;
  padding: 15px;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  font-size:x-large;
  background-color: blue;
  color:white;
}

.playerscores {
    font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    font-size:large;
}

.correct {
    color:green
}
.incorrect {
    color:red
}

</style>