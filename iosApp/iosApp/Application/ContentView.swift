import SwiftUI
import NexleModule

struct ContentView: View {
    @State private var componentHolder = ComponentHolder {
        RootComponent(componentContext: $0, storeFactory: DefaultStoreFactory())
    }
    
	var body: some View {
        RootView(componentHolder.component)
            .onAppear { LifecycleRegistryExtKt.resume(componentHolder.lifecycle) }
            .onDisappear { LifecycleRegistryExtKt.stop(componentHolder.lifecycle) }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
