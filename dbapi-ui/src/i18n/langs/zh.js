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
        sql_query_all_table_name: '查询所有表名称的SQL',
        test_connection: '连接测试',
        save: '保存',
        create_ds: '创建数据源',
        update_ds: '修改数据源',
        export_ds: '导出数据源',
        import_ds: '导入数据源',
        update_time: '修改时间',
        operation: '操作',
        back: '返回',
        ds_sql_tip: '创建或编辑API的时候，选择数据源，会执行此sql来获取该数据源下的所有表名称',
        ds_driver_tip: '如果是其他类型数据库，DBAPI中可能缺少相应的JDBC驱动jar包，请手动将驱动包放入lib目录下',

        create_api: '创建APi',
        create_group:'创建API分组',
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
        access_tip: '开放接口可以直接访问。私有接口在访问时必须在请求头中携带token，且该token值对此接口有访问权限，具体请到权限菜单查看'

    },
    ...zhLocale
}

export default cn