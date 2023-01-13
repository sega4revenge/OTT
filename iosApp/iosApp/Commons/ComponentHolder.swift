import NexleModule

class ComponentHolder<T> {
    let component: T
    let lifecycle: LifecycleRegistry
    
    init(factory: (ComponentContext) -> T) {
        let lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        let component = factory(DefaultComponentContext(lifecycle: lifecycle))
        self.lifecycle = lifecycle
        self.component = component
        
        self.lifecycle.onCreate()
    }
    
    deinit {
        lifecycle.onDestroy()
    }
}
