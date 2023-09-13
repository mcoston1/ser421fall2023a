<script>
import Balance from './components/Balance.vue'
import HelloWorld from './components/HelloWorld.vue'
import Currency from './components/Currency.vue'
import { reactive } from 'vue'

export default reactive({
  data() {
    return {
      fname: "Miranda",
      bal: 0,
    }
  },
  components: {
    Balance,
    HelloWorld,
    Currency
  }
})
</script>

<template>
  <header>
    <div class="wrapper">
      <HelloWorld :name="this.fname" /> 
      <Balance @new-bal="(v) => this.bal=v" />
      <Currency :amount= "this.bal" />
    </div>
  </header>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: left;
    padding-right: calc(var(--section-gap) / 4);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>