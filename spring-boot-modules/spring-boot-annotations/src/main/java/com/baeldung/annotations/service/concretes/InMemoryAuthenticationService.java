package com.baeldung.annotations.service.concretes;

import com.baeldung.annotations.service.interfaces.AuthenticationService;
import org.springframework.stereotype.Service;

/**
 * 我从不将@Component（或@Service...）放在接口上，因为这会使接口无用。让我解释一下原因。
 *
 * 声明1：如果您有一个接口，那么您想将该接口用于注入点类型。
 *
 * 权利要求2：接口的目的是它定义可以由多种实现方式实现的契约。在另一侧，您有注射点（@Autowired）。（IMHO）仅具有一个接口且只有一个实现该接口的类是无用的，并且违反了YAGNI。
 *
 * 事实：当你放：
 *
 * @Component（或@Service，...）在界面上，
 * 有多个实现它的类，
 * 至少有两个类成为Spring Bean，并且
 * 有一个使用该接口进行基于类型的注入的注入点，
 * 然后您将获得和NoUniqueBeanDefinitionException （或者您具有非常特殊的配置设置，包括环境，配置文件或限定符...）
 *
 * 结论：如果在接口上使用@Component（或@Service，...），则必须违反两个规则中的至少一个。因此，我认为放在@Component接口级别上是没有用的（除了一些罕见的情况）。
 */
@Service
public class InMemoryAuthenticationService implements AuthenticationService {

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

}