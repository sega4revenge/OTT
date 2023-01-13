import SwiftUI
import NexleModule

struct WelcomeView: View {
    
    private var component: WelcomeScene
    
    init(_ component: WelcomeScene) {
        self.component = component
    }
    
    var body: some View {
        VStack {
            Text("Welcome View")
        }
    }
}
