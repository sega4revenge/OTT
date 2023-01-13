//
//  AppDelegate.swift
//  iosApp
//
//  Created by Tô Tử Siêu on 13/01/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import UIKit
import NexleModule

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        LogManager.shared.debugBuild()
        return true
    }
}
