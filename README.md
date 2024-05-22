# Description

PoC to access to Gitlab Repository files API from Springboot

## Test

Simple request to API

```java
http://localhost:8080/gitlab/files

Body
{
    "accessToken": <ACCESS_TOKEN>,    
    "projectId": 33,
    "branch": "develop",
    "filePath": "src/app/features/sistema-diseno/compuestos/cards/cards.component.ts"
}
```
