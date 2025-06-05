package com.example.fashionshop;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static ProductRepository instance;
    private final List<Product> productList;

    private ProductRepository() {
        productList = new ArrayList<>();
        loadMockData(); // Можно заменить на загрузку из API/БД
    }

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    private void loadMockData() {
        productList.add(new Product("Футболка", "Vetements", "Мужская одежда", 50000, "Хлопковая футболка", "https://st-cdn.tsum.com/sig/dde6371ab591b57d18bc99e2c28d383e/width/237/i/96/0f/d6/32/5d1525f9-5901-4489-b86a-30505bcfc248.jpg"));
        productList.add(new Product("Джинсы", "Domrebel", "Мужская одежда", 35900, "Прямые джинсы", "https://st-cdn.tsum.com/sig/c29c490ac2d642777577eb2e0f27c44f/width/237/i/4f/e5/52/a5/dd9bba54-8655-4508-a6ef-46abef7476ff.jpg"));
        productList.add(new Product("Платье", "Zara", "Женская одежда", 40000, "Летнее платье", "https://st-cdn.tsum.com/sig/d6e2964b4f0c4814a78c09d140ca2406/width/237/i/b5/a7/99/1a/b3154d59-8b4e-480f-82c3-fa03cdc7bfee.jpg"));
        productList.add(new Product("Джинсы", "MVST", "Женская одежда", 22000, "Узкие джинсы", "https://st-cdn.tsum.com/sig/52234d85cea52e0969b378ebf332aa9b/width/237/i/42/b1/c6/d4/55ebc5f6-c612-4f01-8c21-a8de8bdd47b2.jpg"));
        productList.add(new Product("Кроссовки", "Adidas", "Унисекс обувь", 50000, "Спортивная обувь", "https://st-cdn.tsum.com/sig/4b6be85df5a9957cbe33fb6e50c64797/width/237/i/ad/ad/44/38/9d73a444-ce27-427f-b07a-d8aaeebddf2e.jpg"));
        productList.add(new Product("Ботинки", "Timberland", "Унисекс обувь", 80000, "Зимние ботинки", "https://st-cdn.tsum.com/sig/7cd965cc49e9290e9149688f57e88e3d/width/237/i/c6/c8/f3/7d/df7c23ec-fc9b-4fce-91e7-ebb3e7242c6f.jpg"));
        productList.add(new Product("Футболка", "Nike", "Мужская одежда", 15000, "Удобная футболка", "https://st-cdn.tsum.com/sig/f966b24d89e7b5cfeaeec7969b2f4b8b/width/237/i/bc/e3/42/03/9ec1a648-8f45-4cf0-8eb4-82bcc2f1ca46.jpg"));
        productList.add(new Product("Джинсы", "Levi's", "Мужская одежда", 35000, "Классические джинсы", "https://st-cdn.tsum.com/sig/3635308a6ca50469dc8637a6ac95ec58/width/237/i/5f/f6/22/e2/78be3062-76ef-4845-b941-dcd8e4938d4a.jpg"));
        productList.add(new Product("Платье", "Zara", "Женская одежда", 40000, "Летнее платье", "https://st-cdn.tsum.com/sig/69bc3948c9b62bae4c64bef3929174d6/width/237/i/90/a3/55/b4/90a355b4-c400-3d7b-9d9d-1cbf13e48a49.jpg"));
        productList.add(new Product("Юбка", "H&M", "Женская одежда", 22000, "Короткая юбка", "https://st-cdn.tsum.com/sig/0ffb3c9de8609b3ebc817b810e63f134/width/237/i/ec/e4/d2/a2/9c47005c-5ead-40b1-8413-a3268202a0b5.jpg"));
        productList.add(new Product("Кроссовки", "Adidas", "Унисекс обувь", 15000, "Спортивная обувь", "https://st-cdn.tsum.com/sig/95cf6c4d614f8f03d9a26af04750dcc6/width/237/i/3e/77/9f/22/3e779f22-ec36-36de-b73c-67e2592e2a76.jpg"));
        productList.add(new Product("Ботинки", "Timberland", "Унисекс обувь", 18000, "Зимние ботинки", "https://st-cdn.tsum.com/sig/55cf85515e5ff854fcdde6457b557aa0/width/237/i/37/f0/30/cc/7183a8a4-570d-4b1c-ad81-775189641f73.jpg"));
        productList.add(new Product("Футболка", "Nike", "Мужская одежда", 15000, "Удобная футболка", "https://st-cdn.tsum.com/sig/6866e77ae0e6cb588ef34dbd3a14bfc5/width/237/i/13/8f/eb/19/0da5155e-3082-4010-8873-bbecb2c52635.jpg"));
        productList.add(new Product("Джинсы", "Levi's", "Мужская одежда", 31500, "Классические джинсы", "https://st-cdn.tsum.com/sig/7f9ff1c56aa3f0fb9ee2774dbb62bce3/width/237/i/84/70/d4/c1/58192209-8f1c-43dc-a432-ab4378e0efe1.jpg"));
        productList.add(new Product("Платье", "Zara", "Женская одежда", 42000, "Летнее платье", "https://st-cdn.tsum.com/sig/6493d1e26f12bb838e70ac03319f7eff/width/237/i/a2/31/34/e3/8250a288-6a24-48a4-92a7-8fe62b52a7ac.jpg"));
        productList.add(new Product("Юбка", "H&M", "Женская одежда", 23200, "Короткая юбка", "https://st-cdn.tsum.com/sig/d3d3db1cefc3b6e8a10f51bd167794ce/width/763/i/d8/11/f5/4e/7d7d082a-3816-4519-a6dd-320c11fea3e8.jpg"));
        productList.add(new Product("Кроссовки", "Adidas", "Унисекс обувь", 25000, "Спортивная обувь", "https://st-cdn.tsum.com/sig/554df9c5ab0c58366fa65982a2b2f3c4/width/237/i/9d/20/70/24/b28e7d04-c43f-4e71-a726-f687ddf177b9.jpg"));
        productList.add(new Product("Ботинки", "Timberland", "Унисекс обувь", 68000, "Зимние ботинки", "https://st-cdn.tsum.com/sig/bf1e1d33fdb8ca5e793d12ac323228c7/width/237/i/59/41/c0/4d/ecdfb3a7-5fd4-46f3-80a9-11a307eb9042.jpg"));
    }
}
