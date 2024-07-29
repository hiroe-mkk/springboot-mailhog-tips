# Spring Boot における基本的なメール送信機能の実装方法を説明するサンプルコード

## 起動方法

**1. MailHog コンテナを起動**

```shell
$ docker run -d -p 1025:1025 -p 8025:8025 mailhog/mailhog
```

**2. アプリケーションを起動**

```shell
$ ./gradlew bootRun
```
