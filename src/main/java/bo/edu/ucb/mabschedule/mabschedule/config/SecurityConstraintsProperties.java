package bo.edu.ucb.mabschedule.mabschedule.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "security-constraints")
public class SecurityConstraintsProperties {
    private List<SecurityConstraint> constraints;

    public List<SecurityConstraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<SecurityConstraint> constraints) {
        this.constraints = constraints;
    }


}
