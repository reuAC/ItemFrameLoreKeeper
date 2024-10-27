# ItemFrameLoreKeeper
击落隐形展示框后，掉落物仍保持隐形状态、Lore等  
## 介绍
该插件适用于Spigot1.16及以上。  

通过在配置文件中事先约定好隐形展示框的物品名称、Lore，使得所有掉落的隐形展示框保持配置文件中的状态。
## 指令
`/itemframelorekeeper reload` 重载配置。  
`/itemframelorekeeper get` 获得配置文件中的隐形展示框。

## 配置文件
插件成功启动后，会在plugins文件夹下生成配置文件，位于 `plugins/ItemFrameLoreKeeper/config.yml`  

```yaml
# 隐形展示框的名称
name: "&b&l隐形展示框"
# 隐形展示框的lore
lores:
  - "很不错的展示框"
  - "&a对"
```

## 权限节点
`itemframelorekeeper.main` 使用重载指令。

## 使用方法
1. 将编译完成的jar包放入plugins文件夹中，重启服务器。
