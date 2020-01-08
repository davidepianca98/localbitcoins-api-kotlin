**Localbitcoins Kotlin API Library**

Example usage for dashboard request:

```
val utils = LocalBitcoinsUtils("key", "secret")
utils.getDashboard(LocalBitcoinsRequest.DASHBOARD).data.contactList.forEach { contact ->

}
```

The LocalBitcoinsUtils class has a few helper methods to automatically handle pagination:
```
utils.getOpenTransactions()
utils.getTransactionListUntil(1234567)
```
and more...
