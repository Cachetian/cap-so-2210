# 帮助
#### 常用命令
```shell
cds deploy --to hana:cap_so_2210-db
```

#### V2 array of workaround
```xml
    <dependency>
      <groupId>com.sap.cds</groupId>
      <artifactId>cds-adapter-odata-v2</artifactId>
      <scope>runtime</scope>
    </dependency>
    <command>compile ${project.basedir} -s all -l all -2 edmx-v2 -o ${project.basedir}/src/main/resources/edmx/v2</command>
```
```cds
action saveProducts(products : String) returns String;
```
```java
  @On(event = SaveProductsContext.CDS_NAME)
  public void onSaveProducts(SaveProductsContext context) {
    LOGGER.debug("Enter onSaveProducts -> context.products.length:{}", context.getProducts().length());
    JSONArray jsonArray = new JSONObject(context.getProducts()).getJSONArray("products");
    List<Products> products = new ArrayList<>();
    jsonArray.forEach(item -> {
      Products product = Products.create();
      JSONObject json = (JSONObject) item;
      product.putAll(json.toMap());
      products.add(product);
    });
    Result result = db.run(Upsert.into(PRODUCTS).entries(products));
    context.setResult("success upserted '" + result.rowCount() + "' count");
    context.setCompleted();
  }
```