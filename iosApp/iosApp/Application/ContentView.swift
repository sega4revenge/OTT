import SwiftUI
import NexleModule

struct ContentView: View {
    @State private var componentHolder = ComponentHolder {
        TodoRootComponent(componentContext: $0, storeFactory: DefaultStoreFactory())
    }
    
	var body: some View {
        RootView(componentHolder.component)
            .onAppear { LifecycleRegistryExtKt.resume(self.componentHolder.lifecycle) }
            .onDisappear { LifecycleRegistryExtKt.stop(self.componentHolder.lifecycle) }
	}
}
