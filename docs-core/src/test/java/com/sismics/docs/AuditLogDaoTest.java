package com.sismics.docs;

import com.sismics.docs.core.dao.AuditLogDao;
import com.sismics.docs.core.model.jpa.AuditLog;
import com.sismics.util.context.ThreadLocalContext;
import com.sismics.util.jpa.EMF;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AuditLogDaoTest {
    @Before
    public void setUp() throws Exception {
        // Initialize the entity manager
        EntityManager em = EMF.get().createEntityManager();
        ThreadLocalContext context = ThreadLocalContext.get();
        context.setEntityManager(em);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
    }
    @Test
    public void testCreateAuditLog() {
        // 准备测试数据
        AuditLogDao auditLogDao = new AuditLogDao();
        AuditLog auditLog = new AuditLog();
        // 设置 AuditLog 对象的属性，例如 createDate、type 等

        // 调用被测试的方法
        String id = auditLogDao.create(auditLog);

        // 验证测试结果
        Assert.assertNotNull("返回的 ID 不应为空", id);
    }
}
