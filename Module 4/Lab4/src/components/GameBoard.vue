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
                hasstarted:false
            }
        },
        computed: {

        },    
        methods: {
          category(number) {
          //API call here to get category name
          },
          cat2() {
          //api call here to get category 2 name
          },
        }
    }
</script>

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