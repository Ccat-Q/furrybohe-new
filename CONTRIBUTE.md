# CONTRIBUTE

| 功能包 | 策划案 | 拥有的内容 | 依赖 |
|---|---|---|---|
| `material` | §4.1 步骤1-5, §15, §16 | 树脂/定型树脂/树脂碎片/雕刻树脂碎片/瓶装树脂、棉花/种子(**棉花植株方块**)、16色毛布、填充物(棉花/海绵/羊毛)、**树脂收集器**、**毛布制作台**+`FurRecipe` | shared |
| `fursuit` | §1, §2.2, §4.6-4.7 | 头/爪/脚/尾/身/直腿/曲腿、二级组件(身体含爪/腿含尾/伪全身体)、海绵/树脂/骨头头骨、眼睛/舌头/肉垫、DTD、**各色兽装部位方块**、模型触发、品质、耐久 | shared, material |
| `trait` | §6, §7 | 25 个特性结晶、空白结晶、负面消除结晶、**结晶台**+BE+菜单、镶嵌/升级/耐久/冲突/修复规则 | shared, fursuit |
| `workstation` | §13.1, §9.1 | **兽装工作站**方块+BE+外壳菜单、`WorkstationMode` 插件接口 | shared |
| `crafting` | §4.2-4.7, §9.1 | 6 个制作模式的会话状态机、6 个 UI 小游戏(雕刻/裁剪/缝合/胶粘/摆放/版型) | shared, fursuit, material, trait, workstation |
| `wear` | §5 | 中暑/脏污/潮湿/负重/视野遮挡规则、**晾衣架方块**、玩家穿戴状态缓存、属性修饰符 | shared, fursuit |
| `cleaning` | §8, §9.2 | 小清洗/大清洗/修复流程、深度清洁临时特性、8 个清洗小游戏 | shared, fursuit, wear |
| `document` | §10, §15 | 设计图纸(空白/已设计/预设)、装师手册(P1~P6)、品质升级模板、优质装师认证、**设计编辑模式** | shared, fursuit, workstation |
| `commission` | §11.1-11.2 | 委托单、接单/交付/放弃/超时/欠款、玩家间委托、活儿刷新 | shared, document, fursuit |
| `villager` | §11.3, §12 | 装师/毛布商 2 个职业 + POI + 交易表、**装师小屋结构** | shared, material, fursuit, crystal |
| `advancement` | §14 | 16 主线 + 26 支线触发的自定义部分(其余走 datagen) | 全部（但**无人依赖它**） |

---

# 依赖规则与防环

**允许方向（单向，无环）**：

```
material ──┐
           ├─→ fursuit ──┬─→ trait ──┐
           │             ├─→ wear    ├─→ cleaning
           │             └─→ document ──→ commission
           └─────────────────────────→ villager
workstation ← trait / crafting / document / cleaning / material（只被依赖，不依赖它们）
advancement ← 全部（但无人依赖 advancement）
compat/*    ← 无人依赖
```

- 需要"反向"依赖时，说明缺一个 `shared/` 类型或一个 `platform/` 事件——**不要直接反向 import**。
- 跨功能通信优先走 **Forge 事件**而不是直接方法调用（`wear` 不该 import `cleaning`，而应监听 `FursuitCleanedEvent`）。
- `advancement` 是唯一允许依赖全部的功能包。