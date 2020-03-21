package com.github.wangji92.arthas.plugin.action.arthas;

import com.github.wangji92.arthas.plugin.utils.ClipboardUtils;
import com.github.wangji92.arthas.plugin.utils.NotifyUtils;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * https://alibaba.github.io/arthas/heapdump
 * heapdump  /tmp/dump.hprof 打印堆栈信息 ,有点类似 jmap -dump:format=b,file=/temp/dump.hprof pid
 *
 * @author 汪小哥
 * @date 21-03-2020
 */
public class ArthasHeapDumpCommandAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        DataContext dataContext = event.getDataContext();
        Project project = CommonDataKeys.PROJECT.getData(dataContext);
        if (project == null) {
            return;
        }
        ClipboardUtils.setClipboardString("heapdump /tmp/dump.hprof");
        NotifyUtils.notifyMessage(project, "heapdump /tmp/dump.hprof 已经复制,只要存活对象可以--live");
    }
}
