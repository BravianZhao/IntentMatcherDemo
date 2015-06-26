要想使用隐式 Intent 成功启动 Activity， 必须保证 Intent 中 action、category、data 的设置和要启动的 Activity 的 IntentFilter 相匹配。这是一个 Intent 和 IntentFilter 匹配规则演示的小案例。

### Intent 和 IntentFilter 的使用方法：

1. IntentFilter 中可以设置上的 1-n 个 action、1-n 个 category、0-n 个data
2. Intent 上可以设置 0-1个 action、0-n 个 category、0-1 个 data
3. IntentFilter 上的 data 节点上可以设置 scheme、host、port、path、mimetype 等等
4. Intent 上可以使用 Uri 设置 data，使用字符串设置 mimetype
5. Intent 上的 data 和 type 要么同时设置上，要么只设置 data，要么只设置 type
6. Intent 要成功启动 Activity 必须和 Activity 的 IntentFilter 规则相匹配

### Intent 和 IntentFilter 的相匹配规则：
1. 首先对于 action、category、data 三种类型节点， 如果 IntentFilter 有配置上几种，除 action 类型外，Intent 也必须配置上几种。比如，IntentFilter 下有 5 个 action 和 8 个 category，Intent 至少要配置其中一个 category；如果 IntentFilter 下有 6 个 action，8 个category，2 个 data，Intent 至少要配置一个 category，一个 data
2. Intent 上如果配置多个 category，这些 category 必须都在 IntentFilter 中存在
3. 系统默认会给所有 Intent 配置 “android.intent.category.DEFAULT” category。鉴于这种情况，为了防止 Intent 不能启动 Activity，IntentFilter 下一般也会配置 “android.intent.category.DEFAULT” category
