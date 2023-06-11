# spring-native-dynamodb

## overview

SpringNative で AWS Lambda 関数を作り、
DynamoDB にアクセスするサンプルです。

### setup

AWS Lambda を作成します

- Amazon Linux 2 カスタムランタイム
- 自動作成される IAM ロールに AmazonDynamoDBReadOnlyAccess ポリシーを追加

AWS DynamoDB を作成します

- テーブル名は users
- パーティションキーに userId

### build

```
./mvnw clean package -P native -D skipTests
```

### deploy

AWS マネージメントコンソールより Lambda に作成された zip ファイルをアップロードします。
