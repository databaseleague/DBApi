import zhLocale from 'element-ui/lib/locale/lang/zh-CN' // 引入element语言包

const cn = {
  m: {
    login: '登 录',
    cancel: '取消',
    export: '导出',
    datasource: '数据源',
    authority: '权限',
    settings: '系统设置',
    createDS: '创建数据源',
    exportDS: '导出数据源',
    importDS: '导入数据源',
    database: '数据库',
    name: '名称',
    note: '描述',
    jdbc_driver_class: 'JDBC驱动Class',
    username: '用户名',
    password: '密码',
    edit_password: '修改',
    sql_query_all_table_name: '查询所有表名称的SQL',
    test_connection: '连接测试',
    save: '保存',
    create_ds: '创建数据源',
    update_ds: '修改数据源',
    export_ds: '导出数据源',
    import_ds: '导入数据源',
    ds_detail: '数据源详情',
    update_time: '修改时间',
    operation: '操作',
    back: '返回',
    ds_sql_tip: '创建或编辑API的时候，选择数据源，会执行此sql来获取该数据源下的所有表名称',
    ds_driver_tip: '如果是其他类型数据库，DBAPI中可能缺少相应的JDBC驱动jar包，请手动将驱动包放入lib目录下',

    create_api: '创建API',
    update_api: '修改API',
    api_detail: 'API详情',
    create_group: '创建API分组',
    api_group_manage: 'API分组管理',
    export_api_doc: '导出API文档',
    export_api: '导出API',
    import_api: '导入API',
    export_api_groups: '导出API分组',
    import_api_groups: '导入API分组',
    api_group: 'API分组',
    search: '搜索',
    input_keyword: '请输入关键字',
    path: '路径',
    parameters: '参数',
    access: 'Access',
    private: '私有API',
    public: '开放API',
    data_convert: '数据转换',
    cache: '缓存',
    basic_info: '基本信息',
    access_tip: '开放接口可以直接访问。私有接口在访问时必须在请求头中携带token，且该token值对此接口有访问权限，具体请到权限菜单查看',
    plugin_class: '插件类名',
    plugin_parameter: '插件参数',
    what_is_plugin: '什么是插件',
    what_is_plugin_param: '什么是插件参数',
    request_test: '接口请求测试',
    url: 'URL',
    header: '请求Header',
    result: '返回结果',
    send: '发送请求',
    json_format: 'JSON格式化',
    view_in_table: '表格展示',
    raw_data: '原始数据',

    create_token: '创建Token',
    create_time: '创建时间',
    forever: '永久',
    expire: '过期时间',
    expired: '已过期',
    token_tip: "请求私有接口时，需要把token值放入header的Authorization字段中携带，才可以访问成功。（如果是开放接口，不需要设置header）\n以python为例，访问api的代码示例如下：\n",
    generate: '自动生成',
    expire_tip: '不设置表示永久有效',
    grant: '授权该token访问以下分组的API',

    firewall: '防火墙',
    on: '开启',
    off: '关闭',
    mode: '模式',
    black_list: '黑名单',
    white_list: '白名单',
    ip_list: 'IP名单',
    status: 'IP防火墙状态',
    firewall_settings: 'IP防火墙设置',
    black_tip: '除了黑名单列表中的IP禁止访问API，其他IP一律允许访问',
    white_tip: '只有白名单列表中的IP才允许访问API，其他IP一律禁止访问',
    ip_list_tip: '每行填写一个ip，多个ip用换行符隔开',

    change_pass: '修改密码',
    monitor: '监控',
    detail: '详情',
    query:'查询'

  },
  ...zhLocale
}

export default cn
