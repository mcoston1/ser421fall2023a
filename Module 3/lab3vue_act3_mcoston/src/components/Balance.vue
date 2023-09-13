<script>
export default {
    name: 'Balance',
    
    data() {
        return {
            balance: 100,
            chgamount: 10
        }
    },
    emits: ['new-bal'], 
    computed: {
        balanceString() {
            return this.balance;
        },
    },
    methods: {
        addBalance() {
            this.balance += this.chgamount
            this.$emit('new-bal', this.balance);
            //this.amount = 0;
        },
        subtractBalance() {
            this.balance -= this.chgamount
            this.$emit('new-bal', this.balance);
            //this.amount = 0;
        }
    },
    mounted() {
        console.log('Application mounted');
    },
}
</script>

<template>
    <div class="greetings">
      <span>Account Balance: {{balanceString}}, Amount: {{chgamount}}</span> <br/>
      <label for="slider">Change amount to: </label>
      <input type="range" id="slider" v-model.number="chgamount" min="5" max="100" step="5"> <br/>
      <button @click="addBalance">Add</button>
      <button v-if="chgamount < balance" @click="subtractBalance">Subtract</button>
    </div>
  </template>
  
  <style scoped>
  h1 {
    font-weight: 500;
    font-size: 2.6rem;
    top: -10px;
  }
  
  h3 {
    font-size: 1.2rem;
  }
  
  .greetings h1,
  .greetings h3 {
    text-align: left;
  }
  
  @media (min-width: 1024px) {
    .greetings h1,
    .greetings h3 {
      text-align: left;
    }
  }
  </style>