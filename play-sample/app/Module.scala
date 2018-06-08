import com.google.inject.AbstractModule
import java.time.Clock

import services.Global

class Module extends AbstractModule {

  override def configure() = {
    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)

    bind(classOf[Global]).asEagerSingleton
  }

}
