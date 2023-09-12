//https://play.vuejs.org/#eNrdVktz2zYQ/itbZjpKa9kWRbedYSRP20wObWeSNvWlY/oAkUsRMQSwACjZ0fC/dwE+RPkhNYccEmmkAfbxfbsLYIFt8EtZnq0rDOJgZlLNS3uZSAC8K5W2kGHOKmFh62QAGbPs5XfdDECjrbTczQH+lSqGcDwQVGgsV9LEcD36Eb6Hn2A+GsNoGsEJhBOYg5tdFQhMmg1qsApwjfreFlwugRsY3QzhGiuPdjEdjUdRRH80GhqlheIpepsJaUP3c2ZP2ZpUaYxhMhDlXMaQM2HwEWYMSUDfVlo3g7o1W6EtVEa0fT265AtkGeph5fraUZrmrC/SdTOV6jS8edXTEH43lnhn7T6QQAuc6ti5wimEvS8luOE2LeBlp97zpbyYQQjjoQiA5415kzTMO/C2+Nf85gGK+3gTX86TkwH/QEnsj1Q1IBX6GbQnHYbThUZ2u2fg85l+ZflEX2o+rR2dKLdBdYV7xo+z3Y17GBp029/L6G923ncqmlhclYJZ9DOAWcbXsD7l+TwJPG9DnAS+r5HelEwCz0idKvJEd/BIC/+oCgq2RmjFmFHwSGeYf/wGiJLcLofeVlkmyJH8dNNGYMMMbLd+XNegKgsqh6j19cGdU3TNyIXpcTaFErjgpkgCittVey9434hcfG34ZePlSTr2tNIape2a2VMhlF36rf9+ayKgv1oBedOy1rWDedi/6noAxGVJ6Pa+RILTLOOKEvDYE5/JSmUoXJX9JnUiJiqcT6iVYnqLWYcj2AIF5Eo3npfbbdu/ryc3jtDrL2cLfd7X4Hnq8BB1eJwyfEh5nDE6SBkd55x+Mmd0kDP6H5zRJ3NeTA9xXkyPc148Ws4h86Kylnbfz6ng6S35+puO/N/9MTtvdA9OkOsDe2d/Zuy9cEOAF7uj3bWuVAmlY1hqRNn2nFxJe5qzFRf38eiKr9DAW9zAe7Vikl4lXjIGg5rnQw/DP9IhC3+YfOulviu98N3gM3C5lGJO2Dw9GkPThNoYvNkG+bKwMSyUyF7tGuwQYroHsX/in8c6gtNsgqF3l/pr6leckCl5SrudjWGlpKIumTYXRNPj29VMZDAOLOUmc748+2CUpLeqh246OBeo35X++ZQE/eMrCZgQavO7l7kLoH2kuZ1L7ecJ+Qdz52RJ8KdGWoc1be5eZ5leIu1Gp37z91vamgMlHYlKkPUB5Xs0SlTNTePMfq1kRmEP7Hy0v63cq5vevVfmzZ1Fabqk/A3mCuPtk4Ae7K8PpL4LNzqL2oLWQf0f7VeYBQ==

<script>
  export default {
    data() {
      return {
        qno: 1,
        questions: ['6 * 7 =', '23 + 10 = ', 'The answer to everything is '],
        qanswers: ['42','33','42'],
        choices: ['0','1','13','33','42'],
        score: 0,
        fin: false,
        choice: ""
      }
    },
    methods: {
      questionheader() {
        return this.questions[this.qno-1];
      },

      nextt() {
        let i = this.qno - 1;
        switch (this.qno) {
          case 1:
            if(this.choice == this.qanswers[i]) {
              this.score++;
              this.qno++;
            } else {
              this.qno++;
            }
          break;
          case 2:
            if(this.choice == this.qanswers[i]) {
              this.score++;
              this.qno++;
            } else {
              this.qno++;
            }
          break;
          case 3:
            if(this.choice == this.qanswers[i]) {
              this.score++;
              this.qno++;
            } else {
              this.qno++;
            }
            this.fin = true;
          break;
          
        }
      }


    }
  }
</script>

<template>

  <div v-if="fin == true">
    <span id="completion"> You have completed the quiz! </span> <span id="total">Your score was {{score}} out of 3</span>
  </div>
  <div id="wholebish" v-else-if="fin == false"> 
    <p id="score">Your current score: {{score}} out of 3</p>
    <p id="questionheader">Question {{qno}}: {{questionheader()}}</p>
    <input type="radio" id="0" v-model="choice" value=0 checked>
    <label for="0">{{choices[0]}}</label><br/> 
    <input type="radio" id="1" v-model="choice" value=1>
    <label for="0">{{choices[1]}}</label><br/>
    <input type="radio" id="13" v-model="choice" value=13>
    <label for="0">{{choices[2]}}</label><br/>
    <input type="radio" id="33" v-model="choice" value=33>
    <label for="0">{{choices[3]}}</label><br/>
    <input type="radio" id="42" v-model="choice" value=42>
    <label for="0">{{choices[4]}}</label><br/> <br/>
    <button @click="nextt">OK</button>
  </div>
  
</template>

<style>
  #completion {
    color: green;
    font-family:'Times New Roman', Times, serif;
    font-size: 150%;
  }
  #total {
    color: green;
    font-family:'Times New Roman', Times, serif;
    font-style:italic;
    font-size: 150%;
  }
  #score {
    font-weight: bold;    
    font-size: 120%;
  }
  #questionheader {
    font-weight: bold;
    font-size: 120%;
  }
  label {
    font-family:'Courier New', Courier, monospace;
  }
</style>